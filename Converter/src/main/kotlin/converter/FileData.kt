package converter

enum class FileData(val fileName: String) {

    TK_TO_KUTC(
            "TkToKutc.csv"
    ),

    TND_TO_KUTC(
            "TndToKutc.csv"
    ),

    KUTC_TO_TK(
            "KutcToTk.csv"
    ),

    KUTC_TO_TND(
            "KutcToTnd.csv"
    );

    val filePath: String = "data/%s".format(fileName)
}