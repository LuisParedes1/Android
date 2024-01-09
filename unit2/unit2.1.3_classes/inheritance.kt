// Parent class
open class SmartDevice(val name: String, val category: String) {
   
}

// This parameters aren't properties of SmartTvDevice
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
}


fun main() {
    val home: SmartTvDevice = SmartTvDevice(deviceName = "Samsung",
                                            deviceCategory ="Electornic")
}