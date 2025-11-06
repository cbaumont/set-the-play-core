import assertk.assertThat
import assertk.assertions.isEmpty
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class SearchTracksTest {

    @Test
    fun `should return a list of tracks with their spotifyURI`() {
        val jsonString = readFromResources("spotify/search_track.json")

        val jsonResponse: SearchTracksResponse = json.decodeFromString(jsonString)

        assertThat(jsonResponse.trackItem.tracks.first().name).isEqualTo("Photograph")
        assertThat(jsonResponse.trackItem.tracks.first().type).isEqualTo("track")
        assertThat(jsonResponse.trackItem.tracks.first().uri).isEqualTo("spotify:track:3hb2ScEVkGchcAQqrPLP0R")
        assertThat(jsonResponse.trackItem.tracks.first().album.name).isEqualTo("All the Right Reasons")
    }

    @Test
    fun `should return an empty list of tracks when no tracks are found`() {
        val jsonString = readFromResources("spotify/search_track_empty.json")

        val jsonResponse: SearchTracksResponse = json.decodeFromString(jsonString)

        assertThat(jsonResponse.trackItem.tracks).isEmpty()
    }
}