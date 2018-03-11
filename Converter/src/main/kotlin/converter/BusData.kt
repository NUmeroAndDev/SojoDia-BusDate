package converter

data class BusData(
        val hour: Int,
        val minute: Int,
        val week: Int,
        val isNonstop: Boolean,
        val isOnlyOnSchooldays: Boolean)
