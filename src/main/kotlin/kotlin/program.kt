package kotlin

fun main(array: Array<String>) {
    var m: Meeting? =null
    var newMeeting=Meeting()
    newMeeting=m?:Meeting()
    closeMeeting(m)
    closeMeeting(newMeeting)
    //closses the meeting when it is null
    m?.let{
        closeMeeting(m)}
}
//called when the meeting is nonnull
fun closeMeetingNonNull(m:Meeting):Boolean?{
    return if (m.canClose) m.close()
    else false
}
//allows closing of the meeting when it's null
fun closeMeeting(m:Meeting?):Boolean?{
    return if (m?.canClose==true)m?.close()
    else false
}
class Meeting{
    //late init allows the var to be initialized later in the code
    lateinit var address:Address
    val canClose:Boolean= false
    fun close():Boolean{
        return true
    }
    //is a safe cast and it casts to the type or returns null
    fun save(o:Any){
        val saveable= o as? iSaveable
        saveable?.save()
    }
    //is the late initialization of Address
    fun init(addr:Address){
        address=addr
    }
}
interface iSaveable{
    fun save()
}
//is initialized above using lateinit
class Address{

}