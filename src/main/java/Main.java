import java.io.DataInputStream;

public class Main {


    public static void main(String[] args) {
        Utils utils = new Utils();
        String clientCommand = "";
        while (!clientCommand.equals("Kill")) {
            System.out.println("Please input Your Command");
            clientCommand = utils.getStringConsole();
            switch (clientCommand) {
                case "Select":
                    utils.selectWarmachine();
                    break;
                case "Insert":
                    System.out.println("Please input name and type of warmachine");
                    utils.insertWarmachine(utils.getStringConsole(),utils.getStringConsole());
                    break;
                case "Delete":
                    System.out.println("Please input Id of warmachine you want to delete");
                    utils.deleteWarmachine(Integer.parseInt(utils.getStringConsole()));
                    break;
                case "Update":
                    System.out.println("Please input Id and name of warmachine you want edit");
                    utils.updateWarmachine(Integer.parseInt(utils.getStringConsole()),utils.getStringConsole());
                    break;
                default:
            }
        }
    }


}

