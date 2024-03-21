public class xxxChild extends xxxParent {

    int childFirst;
    int childSecond;


    public xxxChild(int parentFirst, int parentSecond, int childFirst, int childSecond) {
        super(parentFirst, parentSecond);
        this.childFirst = childFirst;
        this.childSecond = childSecond;
    }

    int childSum = childFirst + childSecond;;
    int parentSum = parentFirst + parentSecond;


}
