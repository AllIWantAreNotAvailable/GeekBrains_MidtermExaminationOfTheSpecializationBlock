package Application.View.Interfaces;

public interface ViewInterface {

    void output(String[] strings, String separator, String end);

    void output(String[] strings, String separator);

    void output(String[] strings);

    String input(String[] introduction, String separator, String end);

    String input(String[] introduction, String separator);

    String input(String[] introduction);

}
