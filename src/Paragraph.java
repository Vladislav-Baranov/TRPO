public class Paragraph extends Chapter{
    private String text;

    public Paragraph(String name, int first_page, String text) {
        super(name, first_page);
        setText(text);
    }

    public Paragraph() {}

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return ("    " + getName() + ".............................").substring(0, 30) + getFirst_page();
    }

    @Override
    public int hashCode() {
        return getName().hashCode() + getText().hashCode();
    }

}
