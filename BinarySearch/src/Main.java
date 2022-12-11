import java.lang.Math;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // given an array find if the element exists in the array .

        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,23,45,67,89,99,100,134,456,999};
        // target = 45;
        int[] nums1 = {20,18,16,15,13,12,10,9,7,5,3,2,1,-1234};
        int[] nums2 = {2,3,3,4,4,4,4,4,6,7,7,7,8,9};
        int[] arr1 = {3,4,5,6,-9,0,1,2};
        int[] arr2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
                    //0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,8,0,1,2,3   === 21

        Main m = new Main();

        System.out.println(m.binarySearch1(nums,11));
        System.out.println(m.orderAgnosticSearch(nums,11));
        System.out.println(m.descendingArray(nums1,1));
        System.out.println(m.orderAgnosticSearch(nums1,1));
        System.out.println(m.firstOccurance(nums2,4));
        System.out.println(m.lastOccurance(nums2,4));
        System.out.println(m.countSorted(nums2,4));
        System.out.println(m.findMin(arr1));
       // System.out.println(m.findEleSortedRotatedArray(arr1,5));



        int minIndex = m.findEleSortedRotatedArray(arr1,5);
        int leftsearch = m.binarySearch2(arr1,0,minIndex-1,5);
        int rightSearch = m.binarySearch2(arr1,minIndex,arr1.length-1,5);

        if(leftsearch==-1){
            System.out.println(rightSearch);
        }else{
            System.out.println(leftsearch);
        }


        System.out.println(m.findFloor(nums,12));

        System.out.println(m.findCeil(nums,90));

        System.out.println(m.first1InfiniteSorted(arr2));

        System.out.println(m.minDiff(nums,95));

        // peak element
        int[] ar2 = {5,10,20,15};
        System.out.println("peak element is "+m.peakElement(ar2));

        // bitonic element search
        int[] bitArr = {-3,4,5,6,7,9,10,14,17,19,18,16,13,12,10,9,2,1,-9};
        System.out.println(m.bitonicArraySearch(bitArr));

        // search in 2d array \
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        System.out.println(m.search2dArray(matrix,30));

        int[][] matrix1 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(m.search2dArray(matrix1,18));



    }

    public int binarySearch1(int[] arr,int target){
        int left = 0;
        int right = arr.length -1;

        while(left <= right){
            int middle = left + ((right-left)/2 );
            if(arr[middle] == target){
                return middle;
            }else if(arr[middle]>target){
                right = middle -1;
            }else{
                left = middle+1;
            }

        }

        return -1;
    }


    public int descendingArray(int[] arr,int target){

        int left =0;
        int right = arr.length-1;

        while(left<=right){
            int middle = left +((right-left )/2);
            if(arr[middle] == target){
                return middle;
            }else if(arr[middle] > target){
                left = middle+1;
            }else{
                right = middle+1;
            }
        }

        return -1;
    }

    public int orderAgnosticSearch(int[] arr,int target){
        int left =0;
        int right = arr.length-1;

        if(arr[left] <arr[right]){
            while(left <= right){
                int middle = left + ((right-left)/2 );
                if(arr[middle] == target){
                    return middle;
                }else if(arr[middle]>target){
                    right = middle -1;
                }else{
                    left = middle+1;
                }

            }
        }else{
            while(left<=right){
                int middle = left +((right-left )/2);
                if(arr[middle] == target){
                    return middle;
                }else if(arr[middle] > target){
                    left = middle+1;
                }else{
                    right = middle+1;
                }
            }
        }




        return -1;
    }

    public int firstOccurance(int[] arr,int target){
         int l =0;
         int r =arr.length-1;
         int res =-1;

         while(l<=r){
             int m = l+((r-l)/2);
             if(arr[m] == target){
                 res = m;
                 r = m-1;
             }else if(arr[m] > target){
                 r = m-1;
             }else{
                 l = m+1;
             }



         }
        return res;
    }

    public int lastOccurance(int[] num,int target){
        int l =0;
        int r =num.length-1;
        int res =-1;

        while(l<=r){
            int m = l+((r-l)/2);
            if(num[m] == target){
                res = m;
                l =m+1;
            }else if(num[m] >target ){
                r =m-1;
            }else{
                l = m+1;
            }
        }

        return res;

    }

    public int countSorted(int[] arr,int target){
        int left =0;
        int right = arr.length-1;

        int lastOcc = lastOccurance(arr,target);
        int firstOcc = firstOccurance(arr,target);
        int count = lastOcc-firstOcc +1;
        return count;
    }

    public int findMin(int[] arr) {

        int left =0;
        int right = arr.length-1;
        int n = arr.length;

        while(left <= right){
            int mid = left +((right -left)/2);
            int prev = (mid -1 +n)%n;
            int next = (mid+1)%n;
            if(arr[mid]<= arr[prev] && arr[mid]<= arr[next]){
                return arr[mid];
            }else if(arr[mid] > arr[right]){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }


        return -1;

    }

    public int findEleSortedRotatedArray(int[] arr,int target){

        int left =0;
        int right =arr.length-1;
       ///int minIndex =-1;
//        int res = -1;

        while(left<=right){
            int middle =left+((right-left)/2);
            int prev = (middle -1 + arr.length)%arr.length;
            int next = (middle+1)%arr.length;
            if(arr[middle] <=arr[prev] && arr[middle] <= arr[next]){
                return middle;
            }else if(arr[middle] > arr[right]){
                left = middle +1;
            }else{
                right = middle -1;
            }


        }



        return -1;
    }


    public int binarySearch2(int[] arr, int start, int end,int target){

        while(start <=end ){
            int mid = start +((end-start)/2);
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                end =mid-1;
            }else{
                start =mid+1;
            }
        }




        return -1;
    }


    // find that element because of which the array becomes nearly sorted
    // eg: {1,2,3,4,5,7,6,8,9,10,11,23} 6 is smaller than 7 and 8
    // eg: {1,2,3,4,5,6,7,8,10,9,11,23}  10 is bigger than 8 and 9

//    public int searchingNearlySorted(int[] arr){
//        int left =0;
//        int right = arr.length-1;
//         int n = arr.length;
//
//        while(left<=right){
//            int middle = left +((right-left)/2);
//            int prev = (middle + n -1)%n;
//            int next = (middle+1)%n ;
//            if((arr[middle] >= arr[prev] && arr[middle] >=arr[next])||(arr[middle] <= arr[prev] && arr[middle] <=arr[next])){
//                return arr[middle];
//            }else if(arr[middle] >= arr[prev] && arr[middle] )
//        }
//
//        return -1;
//
//    }


    // {1,2,3,4,6,7,8} x ==5
    // ans == 4 , because is the greatest number present in the array smaller than 5.
    public int findFloor(int[] num,int target){
        int res =-1;
        int left = 0;
        int right = num.length-1;
        while(left<= right){
            int middle = left +((right-left)/2);
            if(num[middle] == target){
                return target;
            }else if(num[middle] > target){
                right = middle-1;
              //  res = num[middle];
            }else{
                left = middle+1;
              res = num[middle];
            }

        }


        return res;
    }


    // find ceil
    // {1,2,3,4,6,7,8,10,12,14,17} x ==11
    // o/p = 12 , it is the smallest number present in array greater than 11.

    public int findCeil(int[] arr, int target){
        int res =-1;
        int left = 0;
        int n = arr.length;
        int right = n-1;
        if(arr[right] < target){
            return -1;
        }

        while(left<= right){
            int middle = left + ((right-left)/2);
            if(arr[middle] == target){
                return arr[middle];
            }else if(arr[middle]>target){
                right = right -1;
                res = arr[middle];
            }else{
                left = middle+1;

            }
        }


        return res;
    }



    public int first1InfiniteSorted(int[] arr){
        int left = 0;
        int right = 1;
        int result =-1;

        while(arr[right] != 1){
            left = right;
            right = right * 2;
        }

        while(left <= right){
            int mid = left + (right-left)/2;

            if(arr[mid] == 1){
                result=  mid;
                right = mid-1;

            }else if(arr[mid]<1){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }


        return result;
    }


    // minimum diffrence element in a sorted array
    public int minDiff(int[] arr,int target){
        int left =0;
        int right = arr.length-1;
        int res =-1;
        while(left<=right){
            int mid = left +((right-left)/2);
            if(arr[mid] == target){
                return arr[mid];
            }else if(arr[mid] >target){
                right =mid-1;
            }else{
                left = mid+1;
            }
        }

        int a = Math.abs(arr[right] -target);
        int b = Math.abs(arr[left]-target);

        res = Math.min(a,b);

        if(res ==a){
            return arr[right];

        }else{
            return arr[left];
        }

    }

    //peak element
    public int peakElement(int[] arr){
        int left =0;
        int right = arr.length-1;
        int n =arr.length;
        if(arr[left] > arr[left +1]){
            return arr[left];
        }else if(arr[right]>arr[right-1]){
            return arr[right];
        }else{
            while(left<=right){
                int mid = left +((right-left)/2);
                int prev = (mid+n-1)%n;
                int next = (mid+1)%n;

                if(arr[mid]>arr[prev] && arr[mid]>arr[next]){
                    return arr[mid];
                }else if(arr[mid]>arr[prev]){
                    left =mid+1;
                }else{
                    right = mid-1;
                }




            }

            return -1;
        }


    }

    // Binary Search in a bitonic Array

    public int bitonicArraySearch(int[] arr){
        int left =0;
        int right = arr.length-1;
        int n = arr.length;
       // int res =-1;
        while(left<=right){
            int mid = left+((right-left)/2);
            int prev = (mid+n-1)%n;
            int next = (mid+1)%n;
            if(arr[mid] > arr[prev] && arr[mid] > arr[next]){
                return arr[mid];
            }else if(arr[mid] > arr[prev] ){
                left =mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }


    public boolean search2dArray(int[][] matrix,int target){
        int i = 0;
        int j = matrix[i].length-1;
        while(i < matrix.length && j >=0 ){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                i++;
            }else{
                j--;
            }
        }

        return false;
    }



}