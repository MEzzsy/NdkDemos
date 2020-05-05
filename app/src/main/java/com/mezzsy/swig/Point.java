/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 4.0.1
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.mezzsy.swig;

public class Point {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Point(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Point obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  @SuppressWarnings("deprecation")
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        UnixJNI.delete_Point(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setX(int value) {
    UnixJNI.Point_x_set(swigCPtr, this, value);
  }

  public int getX() {
    return UnixJNI.Point_x_get(swigCPtr, this);
  }

  public void setY(int value) {
    UnixJNI.Point_y_set(swigCPtr, this, value);
  }

  public int getY() {
    return UnixJNI.Point_y_get(swigCPtr, this);
  }

  public Point() {
    this(UnixJNI.new_Point(), true);
  }

}
