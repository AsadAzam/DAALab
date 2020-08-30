print("\u{001B}[2J")
func binarySearch(arr: [Int], l: Int, r: Int, x: Int) -> Int {
    if r >= l {
        let mid = l + (r - l)
        if (arr[mid] == x) {
            return mid
        }
        else if (arr[mid] > x) {
            return binarySearch(arr: arr, l: l, r: mid - 1, x: x)
        }
        //Else the element can only be present
        else {
            return binarySearch(arr: arr, l: mid + 1, r: r, x: x)
        }
    }
    else {
        return 0
    }
}

let arr = [ 2, 3, 4, 10, 40 ]

print("Enter a number to be found : ", terminator:"")
let input = readLine()
let number = Int(input!)!

let arrLength = arr.count
var result = binarySearch(arr: arr, l: 0, r: arrLength - 1, x: number)
  
if (result != 0) {
    print("Element is present at index \(result)")
}
else {
    print ("Element is not present in array")
}
