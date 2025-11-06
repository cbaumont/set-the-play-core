import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import org.junit.jupiter.api.Test

class SearchSetlistArtistTest {

    @Test
    fun `should search artist by name and return exact match`() {
        val jsonString = readFromResources("setlist_fm/search_artist.json")
        val jsonResponse: SearchArtistResponse = json.decodeFromString(jsonString)

        val someArtist: SetlistArtist? = jsonResponse.findExactArtist("Nickelback")

        assertThat(someArtist?.name).isEqualTo("Nickelback")
        assertThat(someArtist?.setlistFmReference).isEqualTo("bc710bcf-8815-42cf-bad2-3f1d12246aeb")
    }

    @Test
    fun `should return null when artist is not found`() {
        val jsonString = readFromResources("setlist_fm/search_artist.json")
        val jsonResponse: SearchArtistResponse = json.decodeFromString(jsonString)

        val someArtist: SetlistArtist? = jsonResponse.findExactArtist("Joy Division")

        assertThat(someArtist).isNull()
    }
}