import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class TrackModelTest {

    @Test
    fun `should return track model list from setlist`() {
        val jsonString = readFromResources("setlist_fm/setlists.json")
        val jsonResponse: SetlistsResponse = json.decodeFromString(jsonString)
        val someSetlist: Setlist = jsonResponse.getLatestAvailableSetlist()!!

        val trackModelList = someSetlist.mapToTrackModelList()

        assertThat(trackModelList.size).isEqualTo(18)
        assertThat(trackModelList.first().name).isEqualTo("Walk")
        assertThat(trackModelList.first().artist).isEqualTo("Pantera")
        assertThat(trackModelList[1].artist).isEqualTo("Nickelback")
    }
}