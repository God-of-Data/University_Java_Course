import java.util.ArrayList;
import java.util.Iterator;

public class Queue<T> {

    private final static int MAX_PRIORITY_LIMIT = 10;

    private final static int MIN_PRIORITY_LIMIT = 1;

    private ArrayList<T>[] queue;

    private int priorityRange;


    /**
     * Gets priority range and creates the queue as ArrayList of ArrayLists.
     * If n is out of limit throws error.
     *
     * @param n The String that is the question.
     */
    public <T> Queue(int n) throws Exception {

        boolean nIsInQueuePriorityLimit
                = (n >= MIN_PRIORITY_LIMIT) && (n <= MAX_PRIORITY_LIMIT);

        if (nIsInQueuePriorityLimit) {

            this.priorityRange = n;

            this.queue = new ArrayList[n];

            for (int i = 0; i < this.queue.length; i++) {

                this.queue[i] = new ArrayList<>();
            }
        }

        else {

            String errorMessage
                    = "Error! n must be between (" + MIN_PRIORITY_LIMIT + "," + MAX_PRIORITY_LIMIT + ")";

            throw new Exception(errorMessage);
        }
    }


    /**
     * Gets new item and adds it to queue by using priority as index.
     *
     * @param item The item that should be added.
     * @param priority The priority of the inserted item.
     */
    public void add(T item, int priority) {

        int selectedPriority;

        boolean priorityIsInPriorityRange
                = (priority >= MIN_PRIORITY_LIMIT) && (priority <= this.priorityRange);


        if (priorityIsInPriorityRange) {

            selectedPriority = priority - 1;
        }

        else {

            selectedPriority = this.priorityRange - 1;
        }

        this.queue[selectedPriority].add(item);
    }


    /**
     * Checks if queue is not empty. If so, returns first item.
     * Otherwise, returns Null.
     *
     * @return The first item or null if there is no item.
     */
    public T poll() {

        int index = 0;

        boolean currentQueuePriorityIsEmpty = this.queue[index].size() == 0;

        while (index < this.priorityRange && currentQueuePriorityIsEmpty) {

            index++;

            currentQueuePriorityIsEmpty = this.queue[index].size() == 0;
        }

        boolean queueIsEmpty = index >= this.priorityRange;

        if (queueIsEmpty) {

            return null;
        }


        ArrayList<T> returnedItems = new ArrayList<T>();

        returnedItems.add(this.queue[index].remove(0));

        return returnedItems.remove(0);
    }


    /**
     * Checks if queue contains the received item by scanning the queue.
     *
     * @param item The item to be searched for in queue.
     *
     * @return True if item in queue and False otherwise.
     */
    public <T> boolean contains(T item) {

        for (ArrayList priorityList : this.queue) {

            if (priorityList.contains(item)) {

                return true;
            }
        }

        return false;
    }


    /**
     * Checks if queue contains the received item.
     * If so, scans the queue and remove the item.
     *
     * @param item The item to be removed from queue.
     *
     * @return True if item had been in queue and was removed, False otherwise.
     */
    public <T> boolean remove(T item) {

        if (this.contains(item)) {

            for (ArrayList priorityList : this.queue) {

                if (priorityList.contains(item)) {

                    priorityList.remove(item);

                    return true;
                }
            }
        }

        return false;
    }


    /**
     * Scans queue and returns the amount of items in it.
     *
     * @return The number of items in queue.
     */
    public int size() {

        int itemAmount = 0;

        for (ArrayList priorityList : this.queue) {

            itemAmount += priorityList.size();
        }

        return itemAmount;
    }


    /**
     * Creates an iterator to iterate this queue.
     * Defines new next and hasNext methods for the iterator,
     * so the queue scan would be possible.
     *
     * @return An iterator that can scan queue.
     */
    public Iterator<T> iterator(){

        ArrayList<T>[] tempQueue = this.queue;

        int tempRange = this.priorityRange;

        /**
         * Finding the first index to start the scan from.
         */

        int priorityListIndex = 0;


        int index = 0;

        while (priorityListIndex < tempRange) {

            if (tempQueue[index].size() > 0) {

                priorityListIndex = index;

                break;
            }

            index++;
        }

        int finalFirstPriorityListIndex = priorityListIndex;


        Iterator<T> iterator = new Iterator<T>() {

            private ArrayList<T>[] iteratorQueue = tempQueue;

            private int iteratorPriorityIndex = finalFirstPriorityListIndex;

            private int iteratorItemIndex = 0;

            private int iteratorPriorityRange = tempRange;


            /**
             * Scans the queue to find next item.
             * If there is one, returns true. Otherwise, returns false.
             *
             * @return True if there is at least one item to scan and false otherwise..
             */
            @Override
            public boolean hasNext() {

                int priorityIndex = this.iteratorPriorityIndex;

                int itemIndex = this.iteratorItemIndex;

                /**
                 * Scanning priority lists of queue to see if there is an item.
                 */
                while (priorityIndex < iteratorPriorityRange) {

                    boolean thereIsNextItemInPriorityList
                            = this.iteratorQueue[priorityIndex].size() - (itemIndex + 1) >= 0;

                    if (thereIsNextItemInPriorityList) {

                        return true;
                    }

                    priorityIndex++;
                }

                return false;
            }


            /**
             * Goes to next item in queue and returns it and moving iterator indices to next item location.
             *
             * @return The next item in queue.
             */
            @Override
            public T next() {

                int priorityIndex = this.iteratorPriorityIndex;

                int itemIndex = this.iteratorItemIndex;


                /**
                 * Moving iterator indices to next location according to different states.
                 */
                if (this.hasNext()) {

                    int nextItemIndex = itemIndex + 1;

                    int nextPriorityIndex = priorityIndex;


                    boolean thereIsNextItemInCurrentPriorityList
                            = this.iteratorQueue[nextPriorityIndex].size() - (nextItemIndex + 1) >= 0;

                    boolean currentItemIsLastInQueue
                            = (priorityIndex == this.iteratorPriorityRange - 1) && (this.iteratorQueue[priorityIndex].size() - 1 == itemIndex);

                    if (thereIsNextItemInCurrentPriorityList) {

                        this.iteratorPriorityIndex = nextPriorityIndex;

                        this.iteratorItemIndex = nextItemIndex;
                    }

                    else if (currentItemIsLastInQueue) {

                        this.iteratorPriorityIndex = this.iteratorPriorityRange;
                    }

                    /**
                     * In case item is in the next priority lists.
                     */
                    else {

                        nextItemIndex = 0;

                        nextPriorityIndex = priorityIndex + 1;

                        while (nextPriorityIndex < this.iteratorPriorityRange) {

                            boolean thereIsNextItemInPriorityList
                                    = this.iteratorQueue[priorityIndex].size() - (itemIndex + 1) >= 0;

                            if (thereIsNextItemInPriorityList) {

                                this.iteratorPriorityIndex = nextPriorityIndex;

                                this.iteratorItemIndex = nextItemIndex;

                                break;
                            }

                            nextPriorityIndex++;
                        }
                    }
                }

                boolean currentItemExists
                        = this.iteratorQueue[priorityIndex].size() - (itemIndex + 1) >= 0;

                if (currentItemExists) {

                    return this.iteratorQueue[priorityIndex].get(itemIndex);
                }

                return null;
            }
        };

        return iterator;
    }

    @Override
    public String toString() {

        String outputString = "(";

        for (int i = 0; i < this.priorityRange; i++) {

            outputString += this.queue[i];

            if (i < this.priorityRange - 1) {

                outputString += " , ";
            }
        }

        outputString += ")";

        return outputString;
    }
}
