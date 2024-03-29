open class SmartDevice(val name: String, val category: String) {
   
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
        
    var channelNumber = 1
        set(value){
            if (value in 0..200) {
                field = value
            }
        }
        
    fun increaseVolumne(){
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    
    fun nextChannel(){
        channelNumber++
        println("Next channel is $channelNumber")
    }
}


fun main() {
    val home: SmartTvDevice = SmartTvDevice(deviceName = "Samsung",
                                            deviceCategory ="Electornic")
    
    home.increaseVolumne()
    home.nextChannel()
}