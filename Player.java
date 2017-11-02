import java.util.ArrayList;
/**
 * This class handles play, stop, loading of tracks and displays information about current tracks.
 * 
 * @author (Slagnes, Kjell-Olaf) 
 * @version (1.0)
 */
public class Player
{
    private PlayList playList;
    private Track track; // Create an object track of the class Track.
    private String trackName = ""; // Sets an empty string trackName.
    private int tracksPlayed, totalPlayLength = 0;
    private double totalTracks, totalDuration, avgTrackLength = 0;

    /**
     * Create a playlist with tracks from a folder named audio.
     */
    public Player()
    {
        playList = new PlayList("audio");
    }

    /**
     * Return the track collection currently loaded in this player.
     */
    public PlayList getPlayList()
    {
        return playList;
    }

    /**
     * Play the track selected.
     */
    public void play()
    {
        // Check if a track is loaded, then play if a track is loaded.
        if(track != null){
            track.rewind(); //Reset the track so it can be played multiple times.
            track.play(); // Play the track.
            tracksPlayed++; // When a track is played tracksPlayed incremented by 1.
            totalPlayLength += track.getDuration(); // When a track is played add the duration of the track to totalPlayLength.
            averageTrackLength(); // Call the method averageTrackLength.
        }
    }

    /**
     * Stop the track selected.
     */
    public void stop()
    {
        // If a track is playing stop it. If no track is loaded notify in console.
        if(track != null){
            track.stop();
        }
    }

    /**
     * Stop the track currently playing, then load the track selected.
     */
    public void setTrack(int trackNumber)
    {
        stop(); // If a track is playing stop it. Then load track selected.
        track = playList.getTrack(trackNumber);
    }

    /**
     * Return track name. If no track is selected an empty string is returned.
     */
    public String getTrackName()
    {
        // Set the string trackName to the track loaded. 
        if(track != null){
            trackName = track.getName();
        }
        return trackName;
    }
   
    /**
     * Return information about the currently selected track. The information
     * contains the track name and playing time, in the format
     *    track-name (playing time)
     * Return an empty string if no track is selected.
     */
    public String getTrackInfo()
    {
        // Sets an empty string trackInfo, if a track is loaded set trackInfo to "trackName (track-duration)".
        String trackInfo = "";
        if(track != null){
            trackInfo = getTrackName() + " (" + track.getDuration() + ") ";
        }
        return trackInfo;
    }

    /**
     * Return the number of tracks played since the program started.
     */
    public int getNumberOfTracksPlayed(){
        return tracksPlayed;
    }

    /**
     * Return the total play time of songs played.
     */
    public int getTotalPlayedTrackLength(){
        return totalPlayLength;
    }

    /**
     * Return the average track length. If no tracks have been played return 0.
     */
    public double averageTrackLength(){
        totalTracks = getTotalPlayedTrackLength();
        totalDuration = getNumberOfTracksPlayed();
        if(totalTracks != 0){
        avgTrackLength = totalTracks / totalDuration;
        }
        return avgTrackLength;
    }
    
    /**
     * Set statistics values to zero.
     */
    public void resetStatistics(){
        tracksPlayed = 0;
        totalPlayLength = 0;
        avgTrackLength = 0;
        
    }
}
