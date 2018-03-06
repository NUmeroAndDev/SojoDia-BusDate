
# BusDate for SojoDia

## Config.json  
|Key|Type|Description|
|:-----------|:-----------|:-----------|
|version|Int|時刻表データのバージョン|

## BusData.json  

* Parent  

|Key|Type|Description|
|:-----------|:-----------|:-----------|
|KutcToTk|List|関大 -> JR 高槻駅北|
|KutcToTnd|List|関大 -> JR 富田|
|TkToKutc|List|JR 高槻駅北 -> 関大|
|TndToKutc|List|JR 富田 -> 関大|

* ListItem  

|Key|Type|Description|
|:-----------|:-----------|:-----------|
|hour|Int|0 ~ 23|
|minute|Int|0 ~ 59|
|week|Int|0 = Weekday, 1 = Saturday, 2 = Sunday or Holiday|
|isNonstop|Bool|true = 直行便|
|isOnlyOnSchooldays|Bool|true = 登校期間のみ|
