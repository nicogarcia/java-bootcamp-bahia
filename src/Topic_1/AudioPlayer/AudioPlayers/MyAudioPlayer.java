package Topic_1.AudioPlayer.AudioPlayers;

import Topic_1.AudioPlayer.PlayerStates.IPlayerState;
import Topic_1.AudioPlayer.PlayerStates.PausedState;
import Topic_1.AudioPlayer.PlayerStates.PlayingState;
import Topic_1.AudioPlayer.PlayerStates.StoppedState;
import Topic_1.AudioPlayer.Track;

public class MyAudioPlayer implements IAudioPlayer {
	IPlayerState state;
	Track currentTrack;

	static IPlayerState playingState = new PlayingState();
	static IPlayerState stoppedState = new StoppedState();
	static IPlayerState pausedState = new PausedState();

	public MyAudioPlayer() {
		state = stoppedState;
	}

	@Override public void load(Track track) {
		currentTrack = track;
		System.out.println("\tLoad successful!");
	}

	@Override public void pause() {
		state.pause(this);
	}

	@Override public void play() {
		state.play(this);
	}

	@Override public void stop() {
		state.stop(this);
	}

	@Override public IPlayerState getState() {
		return state;
	}

	@Override public void setState(IPlayerState playerState) {
		state = playerState;
	}

	@Override public Track getCurrentTrack() {
		return currentTrack;
	}

	@Override public boolean hasTrackLoaded() {
		return currentTrack != null;
	}
}
