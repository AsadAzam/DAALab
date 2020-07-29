print("\u{001B}[2J")
let a:[Int] = [10, 20, 34, 3, 65, 45, 11, 66, 90, 74]

print("Enter a number to be found : ", terminator:"")
let input = readLine()
let number = Int(input!)

var iterationCount = 0;

for i in 0...(a.count-1) {
    iterationCount += 1
    if (number == a[i]){
        print("Number Found");
        break;
    }
}
print("Total iterations were: \(iterationCount)")

