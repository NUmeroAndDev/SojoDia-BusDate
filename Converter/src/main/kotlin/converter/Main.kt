package converter


import com.google.gson.GsonBuilder
import java.io.File
import java.util.*

fun main(args: Array<String>) {

    val outputData = createOutputData()
    saveFile(outputData)
}

fun createOutputData(): OutputBusData {
    val tkToKutcList: MutableList<BusData> = mutableListOf()
    val tndToKutcList: MutableList<BusData> = mutableListOf()
    val kutcToTkList: MutableList<BusData> = mutableListOf()
    val kutcToTndList: MutableList<BusData> = mutableListOf()

    FileData.values().iterator().forEach {
        val file = File(it.filePath)
        file.readLines().forEachIndexed { index, s ->
            if (index == 0) {
                // 最初の行はテキストなのでスキップする
                return@forEachIndexed
            }
            val tokenizer = StringTokenizer(s, ",")
            val hour = tokenizer.nextToken().toInt()
            val minutes = tokenizer.nextToken().toInt()
            val week = tokenizer.nextToken().toInt()
            val isNonstop = tokenizer.nextToken().toInt() != 0
            val isOnlyOnSchooldays = tokenizer.nextToken().toInt() != 0

            val busData = BusData(hour, minutes, week, isNonstop, isOnlyOnSchooldays)
            when (it) {
                FileData.TK_TO_KUTC -> tkToKutcList.add(busData)
                FileData.TND_TO_KUTC -> tndToKutcList.add(busData)
                FileData.KUTC_TO_TK -> kutcToTkList.add(busData)
                FileData.KUTC_TO_TND -> kutcToTndList.add(busData)
            }
        }
    }
    return OutputBusData(kutcToTkList, kutcToTndList, tkToKutcList, tndToKutcList)
}

fun saveFile(data: OutputBusData) {
    val gson = GsonBuilder().setPrettyPrinting().create()
    val json = gson.toJson(data)
    println(json)
    val dir = File("output")

    if (dir.exists().not()) {
        dir.mkdir()
    }
    val file = File("output/BusData.json")
    file.writeText(json)
    println("Save Success")
}
