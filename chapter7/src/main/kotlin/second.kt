import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

open class PropertyChangeAware{
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.addPropertyChangeListener(listener)
    }
    fun deletePropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.removePropertyChangeListener(listener)
    }
}

class ObservableProperty(
    var propValue: Int,
    val changeSupport: PropertyChangeSupport
){
    operator fun getValue(p: Person, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Person, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class Person(
    val name: String, age: Int, salary: Int
): PropertyChangeAware(){
    private val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
    var age : Int by Delegates.observable(age, observer)
    var salary : Int by Delegates.observable(salary, observer)
}

