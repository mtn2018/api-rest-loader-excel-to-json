package com.ositel.test.entity;


/**
 * Created by xschen on 9/11/2017.
 */

public class UploadEvent {
   private String eventType = "progress";
   private Object state;

   public String getEventType() {
      return eventType;
   }

   public Object getState() {
      return state;
   }

   public void setState(Object state) {
      this.state = state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public void setEventType(String eventType) {
      this.eventType = eventType;
   }
}
