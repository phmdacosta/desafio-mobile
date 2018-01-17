package pedrodacosta.vitrine.desafio.desafiovitrineapp.connections

import android.os.AsyncTask
import pedrodacosta.vitrine.desafio.desafiovitrineapp.ConnecationListener
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.Charset

/**
 * Created by Pedro Henrique on 15/01/2018.
 */
open class Connection(listener: ConnecationListener) : AsyncTask<String, String, String>() {

    lateinit var conn: HttpURLConnection
    var listener: ConnecationListener
    var result: Any?

    init {
        this.listener = listener
        result = null
    }

    override fun doInBackground(vararg params: String?): String {

        val resultConnection = StringBuilder();
        val url: String = getUrl()

        if (url.isNotEmpty()) {
            try {
                val urlConnection: URL = URL(url)
                conn = urlConnection.openConnection() as HttpURLConnection
                conn.connectTimeout = 60000
                conn.readTimeout = 20000
                conn.requestMethod = getMethod()
                conn.addRequestProperty("Content-Type", "application/json")

                val bodyRequest = getBodyRequest()

                if (bodyRequest.isNotEmpty()) {
                    val outputBytes = bodyRequest.toByteArray()
                    val os = conn.outputStream
                    os.write(outputBytes)
                    os.close()
                }

                conn.connect()

                val statusCode: Int = conn.responseCode

                if (statusCode == HttpURLConnection.HTTP_OK) {
                    val inputStr: InputStream = BufferedInputStream(conn.getInputStream())
                    val reader: BufferedReader = BufferedReader(InputStreamReader(inputStr))
                    var line = reader.readLine()
                    while (line != null) {
                        resultConnection.append(line)
                        line = reader.readLine()
                    }
                }
            } catch (e: Exception) {

            }
        }

        return resultConnection.toString()
    }

    override fun onPostExecute(resultConnection: String?) {
        this.result = parseResult(resultConnection)
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

    open fun getBodyRequest(): String {
        return ""
    }
}