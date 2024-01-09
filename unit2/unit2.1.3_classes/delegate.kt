/*
    Using the keyword by you can delegate the behavior to another class.

    The class must follow the same interface
 */

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty


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

      /*
    private var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
        */
        
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)


/*        
    private var channelNumber = 1
        set(value){
            if (value in 0..200) {
                field = value
            }
        }
 */
        private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

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

        /*
    private var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
        */
        
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

        
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
    
class RangeRegulator(
	initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
	): ReadWriteProperty<Any?,Int>{
    
    var fieldData = initialValue
    
    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
    	return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
    	if (value in minValue..maxValue) {
            fieldData = value
        }
    }

}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice(deviceName = "Samsung",
                                            deviceCategory ="Electornic")
   smartDevice.turnOn()
   
   smartDevice = SmartLightDevice("Google Light", "Utility")
   smartDevice.turnOn()
}