package hack

import org.eclipse.jetty.util.security.Password.getPassword
import com.eclipsesource.json.JsonObject



data class Publisher(val id: Int, val name: String, val address: String, val times: String, val offer: String) {
    fun toJson(): JsonObject {
        return JsonObject()
            .add("name", name)
            .add("address", address)
            .add("times", times)
            .add("offer", offer)
    }
}
