import java.util.*;

public class Main {
    public static void ViewContent(HashMap<Chapter, List<Paragraph>> book, List<Chapter> cptrs){
        List <Chapter> lst = new ArrayList<>();
        for (Chapter cpt : cptrs){
            System.out.println(cpt.toString());
            List<Paragraph> values = book.get(cpt);
            for (Paragraph prg: values){
                System.out.println(prg.toString());
            }
        }
    }

    public static void FindKeyWord(HashMap<Chapter, List<Paragraph>> book, List<Chapter> cptrs, String KeyWord){
        for (Chapter cpt : cptrs){
            if (cpt.getName().toLowerCase().contains(KeyWord)) {
                System.out.println(cpt.toString());
            }
            List<Paragraph> values = book.get(cpt);
            for (Paragraph prg: values){
                if (prg.getName().toLowerCase().contains(KeyWord)) {
                    System.out.println(prg.toString());
                }
            }
        }
    }

    public static boolean CheckPage (int cur_page, int prev_page){
        if (cur_page < prev_page) {
            System.out.println("Соблюдайте нумерацию страниц!");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String name;
        int first_page;
        String text;
        boolean f = false;
        int last_page = 1;
        Chapter cpt = new Chapter();
        List<Chapter> chapters = new ArrayList<>();
        Scanner scanner = new   Scanner(System.in);
        HashMap<Chapter, List<Paragraph>> book = new HashMap<>();
        List<Paragraph> paragraphs = new ArrayList<>();
        int way;
        while (true) {
            System.out.println("\n---- MENU ----");
            System.out.println("Просмотр содержания - 1.");
            System.out.println("Добавить главу - 2.");
            System.out.println("Добавить параграф - 3");
            System.out.println("Поиск по содержанию - 4");
            System.out.println("Выход - 0");
            way = scanner.nextInt();
            switch (way) {
                case 1: {
                    if (book.isEmpty()) {
                        System.out.println("Содержание пусто!");
                        break;
                    }
                }
                ViewContent(book, chapters);
                break;



                case 2: {
                    if (f) {
                        System.out.println("Для создания новой главы добавьте хотя бы одну главу в текущую!");
                        continue;
                    }
                    if (cpt.getName() != null){
                        book.put(cpt, paragraphs);
                        paragraphs = new ArrayList<>();
                        cpt = new Chapter();
                    }
                    while (true) {
                        System.out.println("Название главы");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        while (true) {
                            System.out.println("Номер первой страницы");
                            first_page = scanner.nextInt();
                            if (CheckPage(first_page, last_page)) {
                                last_page = first_page;
                                break;
                            }
                        }
                        cpt.setName(name);
                        cpt.setFirst_page(first_page);
                        if (chapters.contains(cpt)){
                            System.out.println("Глава с таким названием уже существует, выберите новое!");
                            continue;
                        }
                        chapters.add(cpt);
                        book.put(cpt, paragraphs);
                        f = true;
                        break;
                    }
                    break;
                }

                case 3:
                {   if (cpt.getName() == null)
                    {
                    System.out.println("Для добавления пунктов добавьте главу!");
                    break;
                        }
                    f = false;
                    while (true) {
                        System.out.println("Название параграфа");
                        scanner.nextLine();
                        name = scanner.nextLine();
                        while (true) {
                            System.out.println("Номер первой страницы");
                            first_page = scanner.nextInt();
                            if (CheckPage(first_page, last_page)) {
                                last_page = first_page;
                                break;
                            }
                        }
                        System.out.println("Текст пункта");
                        scanner.nextLine();
                        text = scanner.nextLine();
                        Paragraph p = new Paragraph();
                        p.setName(name);
                        p.setFirst_page(first_page);
                        p.setText(text);
                        if (paragraphs.contains(p)){
                            System.out.println("Параграф с таким названием уже сущестует, выберите новое!");
                            continue;
                        }
                        paragraphs.add(p);
                        break;
                    }
                    break;
                }

                case 4:
                {if (book.isEmpty())
                {
                    System.out.println("Содержание пусто!");
                    break;
                    }
                System.out.println("Введите слово или фразу для поиска:");
                scanner.nextLine();
                String word = scanner.nextLine().toLowerCase();
                FindKeyWord(book, chapters, word);
                break;
                }

                case 0:
                {
                    return;
                }
            }
        }
    }
}