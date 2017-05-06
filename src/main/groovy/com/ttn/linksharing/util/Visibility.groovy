package com.ttn.linksharing.util

enum Visibility {
PRIVATE,PUBLIC
   static Visibility stringToEnum(String str)
    {
       return  str.equalsIgnoreCase("PUBLIC")? Visibility.PUBLIC : Visibility.PRIVATE
    }
}
