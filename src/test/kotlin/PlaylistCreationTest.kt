import org.junit.jupiter.api.Test

class PlaylistCreationTest {

    @Test
    fun `should create a playlist successfully`() {
        val jsonString = readFromResources("setlist_fm/setlists.json")
        val jsonResponse: SetlistsResponse = json.decodeFromString(jsonString)
        val someSetlist: Setlist = jsonResponse.getLatestAvailableSetlist()!!

//        val somePlaylist = someSetlist.buildPlaylist()
//
//        assertThat(somePlaylist.name).isEqualTo("Nickelback at The OVO Hydro, 16-05-2024")
//        assertThat(somePlaylist.tracks?.first()?.name).isEqualTo("Walk")
//        assertThat(somePlaylist.tracks?.first()?.mainArtist?.name).isEqualTo("Pantera")
//        assertThat(somePlaylist.tracks?.get(1)?.mainArtist?.name).isEqualTo("Nickelback")
    }
}