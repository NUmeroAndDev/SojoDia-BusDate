package converter

import com.google.gson.annotations.SerializedName

data class OutputBusData(
        @SerializedName("KutcToTk")
        val kutcToTkDataList: List<BusData>,
        @SerializedName("KutcToTnd")
        val kutcToTndDataList: List<BusData>,
        @SerializedName("TkToKutc")
        val tkToKutcDataList: List<BusData>,
        @SerializedName("TndToKutc")
        val tndToKutcDataList: List<BusData>)