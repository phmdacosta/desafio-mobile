package pedrodacosta.vitrine.desafio.desafiovitrineapp.connections

import android.os.AsyncTask
import pedrodacosta.vitrine.desafio.desafiovitrineapp.ConnecationListener
import java.io.*
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by Pedro Henrique on 15/01/2018.
 */
open class Connection(listener: ConnecationListener) : AsyncTask<String, String, String>() {

    lateinit var conn: HttpURLConnection
    var listener: ConnecationListener
    var result: Any?
        get() {
            return field
        }

    init {
        this.listener = listener
        result = null
    }

    override fun doInBackground(vararg params: String?): String {

        val result: StringBuilder = StringBuilder();
        val url: String = getUrl()

        if (url != null || !url.isNullOrEmpty()) {
            try {
                val urlConnection: URL = URL(params.toString())
                conn = urlConnection.openConnection() as HttpURLConnection
                conn.connectTimeout = 60000
                conn.readTimeout = 20000
                conn.requestMethod = getMethod()
                conn.addRequestProperty("Content-Type", "application/json")
                conn.connect()

                val statusCode: Int = conn.responseCode

                if (statusCode == HttpURLConnection.HTTP_OK) {
                    val inputStr: InputStream = BufferedInputStream(conn.getInputStream())
                    val reader: BufferedReader = BufferedReader(InputStreamReader(inputStr))
                    var line: String?
                    while (reader.readLine() != null) {
                        line = reader.readLine()
                        result.append(line)
                    }
                }
            } catch (e: Exception) {

            }
        }

        return result.toString()
    }

    override fun onPostExecute(result: String?) {
        this.result = parseResult(result)
        listener.getConnectionResult(this.result)
    }

    open fun parseResult(json: String?): Any? {
        return null
    }

    open fun getUrl(): String {
        return ""
    }

    open fun getMethod(): String {
        return ""
    }
}