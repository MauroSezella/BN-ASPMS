import javax.swing.SwingUtilities;
import IU.BayesianNetworkUI;

public class App {

        public static void main(String[] args) {

                new smile.License(
                                "SMILE LICENSE a288bbf2 f22bc170 4d1da11e " +
                                                "THIS IS AN ACADEMIC LICENSE AND CAN BE USED " +
                                                "SOLELY FOR ACADEMIC RESEARCH AND TEACHING, " +
                                                "AS DEFINED IN THE BAYESFUSION ACADEMIC " +
                                                "SOFTWARE LICENSING AGREEMENT. " +
                                                "Serial #: 5xscv33zrd0ue56fipab0z8wa " +
                                                "Issued for: Mauro Sezella (maurosezella@gmail.com) " +
                                                "Academic institution: Universidad Nacional de Santiago del Estero " +
                                                "Valid until: 2026-03-26 " +
                                                "Issued by BayesFusion activation server",
                                new byte[] {
                                                -73, -40, 23, -46, -48, 55, -73, 120, 22, -44, 127, 46, 75, 121, 66, 27,
                                                43, -84, 37, -43, -33, -82, -77, 29, 105, -26, -10, 14, 11, -48, 3, 3,
                                                78, 56, 23, -51, 119, -126, -13, -17, -111, -18, -73, -36, -107, 86,
                                                -59, -106,
                                                7, -99, 108, 9, -37, -31, -104, -88, -91, -105, -100, 67, -47, 100, 116,
                                                -66
                                });

                SwingUtilities.invokeLater(() -> new BayesianNetworkUI());

        }
}
