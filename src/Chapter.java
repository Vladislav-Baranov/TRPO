public class Chapter{
    private String name;
    private int first_page;


    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Chapter otherCpt = (Chapter) obj;
        return name.equals(otherCpt.name);
    }

    public Chapter(String name, int first_page)
    {
        setName(name);
        setFirst_page(first_page);
    }

    public Chapter() {};

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getFirst_page()
    {
        return first_page;
    }

    public void setFirst_page(int first_page)
    {
        this.first_page = first_page;
    }


    public String toString()
    {
        return (getName() + ".............................").substring(0, 30) + getFirst_page();
    }

}
