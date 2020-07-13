package com.blacamdk.template.utils;

import java.math.BigDecimal;

public class Consts {
  /** 保留小数位数 */
  public static final int DECIMAL_SCALE = 2;
  /** 保留小数策略 */
  public static final int DECIMAL_ROUNDING_MODE = BigDecimal.ROUND_DOWN;

  /** JSON日期格式 */
  public static final String GSON_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
}
