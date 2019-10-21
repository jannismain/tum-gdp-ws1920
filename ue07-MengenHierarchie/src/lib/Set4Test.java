package lib;

// C. Herzog fuer Grundlagen der Programmierung, November 2018

class Set4Test {

    public static void main(String[] args) {
        ArrayIntSet arrSet = new ArrayIntSet();
        arrSet.insert(1);
        arrSet.insert(5);
        arrSet.insert(3);
        System.out.println(arrSet);
        OrderedListIntSet oListSet = new OrderedListIntSet();
        oListSet.insert(2);
        oListSet.insert(6);
        oListSet.insert(4);
        System.out.println(oListSet);
        OrderedArrayIntSet oArrSet1 = new OrderedArrayIntSet(arrSet);
        System.out.println(oArrSet1);
        OrderedArrayIntSet oArrSet2 = new OrderedArrayIntSet(oListSet);
        System.out.println(oArrSet2);
        System.out.println(oListSet.isEmpty() + ", " + oListSet.size());
        System.out.println(oArrSet1.isEmpty() + ", " + oArrSet1.size());
        System.out.println(oArrSet1.isSubset(arrSet) + ", " + oArrSet1.isSubset(oListSet));
    }
}
