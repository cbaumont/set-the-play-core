class PlaylistSummary(private val playlist: Playlist) {
    fun title(): String = "${playlist.name} (${playlist.tracks?.size ?: 0} tracks)"

    fun lines(models: List<TrackModel>): List<String> =
        models.mapIndexed { index, model -> "${index + 1}. ${model.displayName()} :)" }
}
