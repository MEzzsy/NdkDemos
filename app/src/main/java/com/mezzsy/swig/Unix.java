/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.mezzsy.swig;

public class Unix implements UnixConstants {
  public static void setGlobal_int(int value) {
    UnixJNI.global_int_set(value);
  }

  public static int getGlobal_int() {
    return UnixJNI.global_int_get();
  }

  public static long getuid() {
    return UnixJNI.getuid();
  }

}
