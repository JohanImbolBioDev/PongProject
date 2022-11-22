package game;




public class Hilo extends Thread {

    private final PanelJuego panel;

    public Hilo(PanelJuego panel){
        this.panel = panel;
    }

    @Override 
    public void run(){
        while(true){
         try {
            Thread.sleep(panel.SpeedGame,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        panel.repaint();
    }
    }

}
