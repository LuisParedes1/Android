/*
    Ideally, you should strive for strict visibility of properties and methods, 
    so declare them with the private modifier as often as possible. 
    
    If you can't keep them private, use the protected modifier. 
    If you can't keep them protected, use the internal modifier. 
    If you can't keep them internal, use the public modifier. 
*/

open class SmartDevice(val name: String, val category: String) {
    
    	var deviceStatus = "online" 
    	protected set
    
    open val deviceType = "unknown"

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

   
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
        
    override val deviceType = "Smart TV"    
        
	var deviceTurnOnCount = 0
        private set

    private var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
        
    private var channelNumber = 1
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
    
    fun turnOnTv() {
        deviceTurnOnCount++
        turnOn()
    }

    
    override fun turnOff(){
        super.turnOff()
        println("$name turned off")
    }
    
    fun turnOffTv() {
        deviceTurnOnCount--
        turnOff()
    }

}
    
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
        
    override val deviceType = "Smart Light"  
        
    var deviceTurnOnCount = 0
        private set

    private var brightnessLevel = 0
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
    fun turnOnLight() {
        deviceTurnOnCount++
        turnOn()
    }

    fun turnOffLight() {
        deviceTurnOnCount--
        turnOff()
    }

}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice(deviceName = "Samsung",
                                            deviceCategory ="Electornic")
   smartDevice.turnOn()
   
   smartDevice = SmartLightDevice("Google Light", "Utility")
   smartDevice.turnOn()
}