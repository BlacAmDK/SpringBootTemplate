package com.blacamdk.template.utils;

import com.blacamdk.template.model.Result;
import com.google.gson.*;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

/** Created by BlacAmDK on 2020/3/21. */
public class GsonUtils {

  public static Gson gson() {
    return getCommonGsonBuilder().create();
  }

  /**
   * 获取过滤指定字段的json解析器
   *
   * @param filterWord 要指定的过滤字段
   * @return 带解析器的gson对象
   */
  public static Gson getGsonWithFilter(String... filterWord) {
    return getCommonGsonBuilder()
        .setExclusionStrategies(
            new ExclusionStrategy() {
              @Override
              public boolean shouldSkipField(FieldAttributes f) {
                if (f.getDeclaringClass() == Result.class) {
                  return false;
                }
                return Arrays.stream(filterWord)
                    .parallel()
                    .noneMatch(f.getName()::equalsIgnoreCase);
              }

              @Override
              public boolean shouldSkipClass(Class<?> clazz) {
                return false;
              }
            })
        .create();
  }

  public static GsonBuilder getCommonGsonBuilder() {
    return new GsonBuilder()
        .registerTypeAdapter(
            BigDecimal.class,
            (JsonSerializer<BigDecimal>)
                (value, theType, context) ->
                    new JsonPrimitive(
                        value
                            .setScale(Consts.DECIMAL_SCALE, Consts.DECIMAL_ROUNDING_MODE)
                            .toPlainString()))
        .setDateFormat(Consts.GSON_DATE_FORMAT);
  }

  /**
   * 以字符串形式获取json对象的指定key
   *
   * @param jsonElement json对象
   * @param key 键
   * @return 对应的值, 若无法取得或值为null则返回null
   */
  public static String getAsString(@NonNull JsonElement jsonElement, @NonNull String key) {
    JsonElement element = get(jsonElement, key);
    if (element == null || !element.isJsonPrimitive()) {
      return null;
    }
    JsonPrimitive jsonPrimitive = element.getAsJsonPrimitive();
    if (jsonPrimitive.isJsonNull() || !jsonPrimitive.isString()) {
      return null;
    }
    return jsonPrimitive.getAsString();
  }

  /**
   * 以数字形式(Long)获取json对象的指定key
   *
   * @param jsonElement json对象
   * @param key 键
   * @return 对应的值, 若无法取得或值为null则返回null
   */
  public static Long getAsLong(@NonNull JsonElement jsonElement, @NonNull String key) {
    JsonElement element = get(jsonElement, key);
    if (element == null || !element.isJsonPrimitive()) {
      return null;
    }
    JsonPrimitive jsonPrimitive = element.getAsJsonPrimitive();
    if (jsonPrimitive.isJsonNull() || !jsonPrimitive.isNumber()) {
      return null;
    }
    return jsonPrimitive.getAsLong();
  }

  /**
   * 合并jsonObject
   *
   * @param destinationObject 合并后的jsonObject
   * @param conflictResolutionStrategy 冲突策略
   * @param objs 要合并的jsonObject
   * @throws JsonObjectExtensionConflictException 冲突异常
   */
  public static void extendJsonObject(
      JsonObject destinationObject, ConflictStrategy conflictResolutionStrategy, JsonObject... objs)
      throws JsonObjectExtensionConflictException {
    for (JsonObject obj : objs) {
      extendJsonObject(destinationObject, obj, conflictResolutionStrategy);
    }
  }

  private static void extendJsonObject(
      JsonObject leftObj, JsonObject rightObj, ConflictStrategy conflictStrategy)
      throws JsonObjectExtensionConflictException {
    for (Map.Entry<String, JsonElement> rightEntry : rightObj.entrySet()) {
      String rightKey = rightEntry.getKey();
      JsonElement rightVal = rightEntry.getValue();
      if (leftObj.has(rightKey)) {
        // conflict
        JsonElement leftVal = leftObj.get(rightKey);
        if (leftVal.isJsonArray() && rightVal.isJsonArray()) {
          JsonArray leftArr = leftVal.getAsJsonArray();
          JsonArray rightArr = rightVal.getAsJsonArray();
          // concat the arrays -- there cannot be a conflict in an array, it's just a collection of
          // stuff
          for (int i = 0; i < rightArr.size(); i++) {
            leftArr.add(rightArr.get(i));
          }
        } else if (leftVal.isJsonObject() && rightVal.isJsonObject()) {
          // recursive merging
          extendJsonObject(leftVal.getAsJsonObject(), rightVal.getAsJsonObject(), conflictStrategy);
        } else { // not both arrays or objects, normal merge with conflict resolution
          handleMergeConflict(rightKey, leftObj, leftVal, rightVal, conflictStrategy);
        }
      } else { // no conflict, add to the object
        leftObj.add(rightKey, rightVal);
      }
    }
  }

  private static void handleMergeConflict(
      String key,
      JsonObject leftObj,
      JsonElement leftVal,
      JsonElement rightVal,
      ConflictStrategy conflictStrategy)
      throws JsonObjectExtensionConflictException {
    {
      switch (conflictStrategy) {
        case PREFER_FIRST_OBJ:
          break; // do nothing, the right val gets thrown out
        case PREFER_SECOND_OBJ:
          leftObj.add(key, rightVal); // right side auto-wins, replace left val with its val
          break;
        case PREFER_NON_NULL:
          // check if right side is not null, and left side is null, in which case we use the right
          // val
          if (leftVal.isJsonNull() && !rightVal.isJsonNull()) {
            leftObj.add(key, rightVal);
          } // else do nothing since either the left value is non-null or the right value is null
          break;
        case THROW_EXCEPTION:
          throw new JsonObjectExtensionConflictException(
              "Key "
                  + key
                  + " exists in both objects and the conflict resolution strategy is "
                  + conflictStrategy);
        default:
          throw new UnsupportedOperationException(
              "The conflict strategy " + conflictStrategy + " is unknown and cannot be processed");
      }
    }
  }

  private static JsonElement get(@NonNull JsonObject jsonObject, @NonNull String key) {
    return jsonObject.get(key);
  }

  private static JsonElement get(@NonNull JsonElement jsonElement, @NonNull String key) {
    JsonObject jsonObject = jsonElement.getAsJsonObject();
    return get(jsonObject, key);
  }

  public static enum ConflictStrategy {
    THROW_EXCEPTION,
    PREFER_FIRST_OBJ,
    PREFER_SECOND_OBJ,
    PREFER_NON_NULL;
  }

  public static class JsonObjectExtensionConflictException extends Exception {

    public JsonObjectExtensionConflictException(String message) {
      super(message);
    }
  }
}
