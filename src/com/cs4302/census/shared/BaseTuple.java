package com.cs4302.census.shared;

import java.util.Date;

import prefuse.data.Schema;
import prefuse.data.Table;
import prefuse.data.Tuple;

/**
 * Tuple implementation that pulls values from a backing data Table.
 * 
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class BaseTuple implements Tuple {

  long id;
  
  public BaseTuple(long id){
    this.id = id;
  }
  
  public long getID(){
    return id;
  }
  
  @Override
  public boolean canGet(String arg0, Class arg1) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canGetBoolean(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canGetDate(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canGetDouble(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canGetFloat(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canGetInt(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canGetLong(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canGetString(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canSet(String arg0, Class arg1) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canSetBoolean(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canSetDate(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canSetDouble(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canSetFloat(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canSetInt(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canSetLong(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean canSetString(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Object get(String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean getBoolean(String arg0) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getColumnCount() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getColumnIndex(String arg0) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public String getColumnName(int arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Class getColumnType(String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Class getColumnType(int arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Date getDate(String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getDefault(String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public double getDouble(String arg0) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public float getFloat(String arg0) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getInt(String arg0) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public long getLong(String arg0) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int getRow() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Schema getSchema() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getString(String arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Table getTable() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object getValueAt(int arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isValid() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void revertToDefault(String arg0) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void set(String arg0, Object arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setBoolean(String arg0, boolean arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setDate(String arg0, Date arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setDouble(String arg0, double arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setFloat(String arg0, float arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setInt(String arg0, int arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setLong(String arg0, long arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setString(String arg0, String arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void setValueAt(int arg0, Object arg1) {
    // TODO Auto-generated method stub
    
  }

  
  

}