package com.ttn.linksharing.util

enum Seriousness {
    SERIOUS,VERY_SERIOUS,CASUAL
static stringToEnum(String seriousness)
{
    if (seriousness.equalsIgnoreCase("casual"))
        Seriousness.CASUAL
    else if (seriousness.equalsIgnoreCase("serious"))
         Seriousness.SERIOUS
    else
        Seriousness.VERY_SERIOUS
}
}
