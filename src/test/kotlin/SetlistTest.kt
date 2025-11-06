import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNotNull
import assertk.assertions.isNull
import org.junit.jupiter.api.Test

class SetlistTest {

    @Test
    fun `should return latest available setlist`() {
        val jsonString = readFromResources("setlist_fm/setlists.json")
        val jsonResponse: SetlistsResponse = json.decodeFromString(jsonString)

        val someSetlist: Setlist? = jsonResponse.getLatestAvailableSetlist()

        assertThat(someSetlist?.eventDate).isEqualTo("16-05-2024")
        assertThat(someSetlist?.artist).isEqualTo(SetlistArtist("Nickelback", "bc710bcf-8815-42cf-bad2-3f1d12246aeb"))
        assertThat(someSetlist?.tour).isEqualTo(Tour("Get Rollin'"))
        assertThat(someSetlist?.venue).isEqualTo(Venue("The OVO Hydro"))
        assertThat(someSetlist?.name).isEqualTo("The OVO Hydro, 16-05-2024")
        assertThat(someSetlist?.sets?.setItems).isNotNull()
        assertThat(someSetlist?.sets?.setItems?.first()?.setlistSongs?.size).isEqualTo(16)
        assertThat(someSetlist?.sets?.setItems?.first()?.setlistSongs?.first()?.name).isEqualTo("Walk")
    }

    @Test
    fun `should return null if no setlists are found`() {
        val jsonString = readFromResources("setlist_fm/setlists_empty.json")
        val jsonResponse: SetlistsResponse = json.decodeFromString(jsonString)

        val someSetlist: Setlist? = jsonResponse.getLatestAvailableSetlist()

        assertThat(someSetlist).isNull()
    }
}