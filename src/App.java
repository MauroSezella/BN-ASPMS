import javax.swing.SwingUtilities;
import IU.BayesianNetworkUI;

public class App {

    public static void main(String[] args) {

        new smile.License(
                "SMILE LICENSE 171a4b7e 471987c8 0ba55192 " +
                        "THIS IS AN ACADEMIC LICENSE AND CAN BE USED " +
                        "SOLELY FOR ACADEMIC RESEARCH AND TEACHING, " +
                        "AS DEFINED IN THE BAYESFUSION ACADEMIC " +
                        "SOFTWARE LICENSING AGREEMENT. " +
                        "Serial #: 4iktymxi89kq3mt69f56rpl2l " +
                        "Issued for: Mauro Sezella (maurosezella@gmail.com) " +
                        "Academic institution: Universidad Nacional de Santiago del Estero " +
                        "Valid until: 2025-09-23 " +
                        "Issued by BayesFusion activation server",
                new byte[] {
                        -103, -59, -60, -81, -100, -2, 116, -50, 24, 126, -54, 5, 99, -46, 122, -23,
                        -83, -55, 42, -70, 62, 110, -61, 98, 31, 57, 66, 74, 27, 30, 84, -63,
                        -48, 32, 17, 113, 17, -126, -17, -60, -89, 43, -102, -48, -56, 97, 71, 98,
                        116, -122, 15, -120, 109, -42, 5, -124, -68, 80, 20, 8, -126, -65, 37, -3
                });

        SwingUtilities.invokeLater(() -> new BayesianNetworkUI());

    }
}
