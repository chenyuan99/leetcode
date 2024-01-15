public class KeyValueSnapshot {

    class Snapshots{
        private Map<Integer,Integer> dataStore;
        private Map<Integer,Map<Integer,Integer>> snapshots;
        private int snapId;
        
        public Snapshots() {
            dataStore = new HashMap<>();
            snapshots = new HashMap<>();
            snapId = 0;
        }
        
        public int get(int key, int snapId) {
            if(!snapshots.containsKey(snapId)){
                return -1;
            }
            Map<Integer, Integer> snapShot = snapshots.get(snapId);
            if(!snapShot.containsKey(key)) {
                return -1;
            }
            return snapShot.get(key);
        }
        
        public void put(int key, int value) {
            dataStore.put(key,value);
        }
        
        public int takeSnapshot(){
            Map<Integer, Integer> currentSnapshot = new HashMap<>();
            int currentSnapId;
            for(Map.Entry<Integer,Integer> entry: dataStore.entrySet()) {
                currentSnapshot.put(entry.getKey(),entry.getValue());
            }
            snapshots.put(snapId,currentSnapshot);
            currentSnapId = snapId;
            snapId++;
            return currentSnapId;
        }
        
        public void deleteSnapshot(int snapId) {
            snapshots.remove(snapId);
        }
    }
    
    
    public class Main {
        public static void main(String[] args) {
            System.out.println("Hello World!");
            
        Snapshots snapShotObject  = new Snapshots();
        int snapId1;
        int snapId2;
        snapShotObject.put(1,10);
        snapShotObject.put(2,13);
        snapShotObject.put(3,17);
        snapShotObject.put(4,19);
        snapShotObject.put(5,100);
        snapId1 = snapShotObject.takeSnapshot();
        snapShotObject.put(1,100);
        snapShotObject.put(2,131);
        snapShotObject.put(3,171);
        snapShotObject.put(4,191);
        snapShotObject.put(5,200);
        snapId2 = snapShotObject.takeSnapshot();    
        System.out.println("SanpId: "+snapId1+" Key: 1 "+"Value: "+snapShotObject.get(1,snapId1));
        System.out.println("SanpId: "+snapId2+" Key: 1 "+"Value: "+snapShotObject.get(1,snapId2));
            
        System.out.println("SanpId: "+snapId1+" Key: 2 "+"Value: "+snapShotObject.get(2,snapId1));
        System.out.println("SanpId: "+snapId2+" Key: 2 "+"Value: "+snapShotObject.get(2,snapId2));
            
        snapShotObject.deleteSnapshot(snapId1);
        System.out.println("SanpId: "+snapId1+" Key: 1 "+"Value: "+snapShotObject.get(1,snapId1));
        }
    }
    
}

// https://leetcode.com/discuss/interview-question/object-oriented-design/339625/Rubrik-or-Key-value-store-with-snapshot