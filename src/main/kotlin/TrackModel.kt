data class TrackModel(
    val name: String? = null,
    val artist: String? = null,
    val album: String? = null,
    val spotifyURI: String? = null,
) {
    fun displayName(): String = listOfNotNull(artist, name).joinToString(" - ")
}

internal fun Setlist.mapToTrackModelList(): List<TrackModel> =
    sets.setItems
        .flatMap { it.setlistSongs }
        .map {
            TrackModel(
                name = it.name,
                artist = it.coverArtist?.name ?: artist.name
            )
        }

internal fun TrackItem.mapToTrackModelList(): List<TrackModel> = tracks.map {
    TrackModel(
        album = it.album.name,
        spotifyURI = it.uri,
    )
}
//TODO how to map both lists to the same?