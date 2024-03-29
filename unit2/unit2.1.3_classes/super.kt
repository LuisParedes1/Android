/*
    In this example we call functions from the parent class using super keyword
 */
open class SmartDevice(val name: String, val category: String) {
    
    var deviceStatus = "online"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

   
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
    
    override fun turnOn(){
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                "set to $channelNumber."
        )

    }
    
    override fun turnOff(){
        super.turnOff()
        println("$name turned off")

    }
}
    
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
        
    fun increaseBrightness(){
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    
    override fun turnOn(){
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }
    
    override fun turnOff(){     
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")

    }
}
    
    


fun main() {
    var smartDevice: SmartDevice = SmartTvDevice(deviceName = "Samsung",
                                            deviceCategory ="Electornic")
   smartDevice.turnOn()
   
   smartDevice = SmartLightDevice("Google Light", "Utility")
   smartDevice.turnOn()
}