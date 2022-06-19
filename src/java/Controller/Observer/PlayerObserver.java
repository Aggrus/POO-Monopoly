package Controller.Observer;

import enums.PlayerColorEnum;

public interface PlayerObserver extends Observer
{
    public void nofityBoardPosition(Integer boardPosition);
    public void nofityColor(PlayerColorEnum color);
    public void notifyFreeRide(boolean freeRide);
    public void notifyInPrision(boolean inPrision);
    public void notifyMoney(Long money);
    public void notifyPrisionTime(Integer prisionTime);
    public void notifyRoundTrips(Integer roundTrips);

	//private boolean inGame needed?
}
