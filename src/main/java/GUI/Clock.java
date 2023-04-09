package GUI;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

class Clock {
    private Timer mTimer = new Timer();
    JLabel jl;
    private int mSecondsPassed = 0;
     public Clock(JLabel jl) {
          this.jl = jl;
    }
    private TimerTask mTask = new TimerTask() {
        @Override
        public void run() {
            mSecondsPassed++;
            Date now = new Date();
            String format2 = new SimpleDateFormat("EEE, dd-MM-yyyy HH:mm:ss", Locale.ENGLISH).format(now);
            jl.setText(format2);
           System.out.println("Seconds passed: " + format2);
        }
    };

    void start() {
        mTimer.scheduleAtFixedRate(mTask, 1000, 1000);
    }

//    public static void main(String[] args) {
//        Clock c = new Clock();
//        c.start();
//    }
}