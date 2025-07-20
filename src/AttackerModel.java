public class AttackerModel extends DefenderModel {
    private AttackerView attackerView = new AttackerView();

    private int atkPower;
    private String name;
    private String atkType;

    // Constructor
    public AttackerModel() {
    }
    public AttackerModel(int atkPower, String name, String atkType) {
        this.atkPower = atkPower;
        this.name = name;
        this.atkType = atkType;
    }

    // Getter
    public AttackerView getAttackerView() {
        return attackerView;
    }
    @Override
    public String getAtkType() {
        return atkType;
    }
    @Override
    public int getAtkPower() {
        return atkPower;
    }
    @Override
    public String getName() {
        return name;
    }

    // Setter
    @Override
    public void setAtkPower(int atkPower) {
        this.atkPower = atkPower;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setAtkType(String atkType) {
        this.atkType = atkType;
    }

    // View Methods
    public void updateView(int atkPower, String name) {
        attackerView.display(atkPower, name);
    }
    public int getTempAtkPower() {
        return attackerView.tempAtkPower;
    }
}