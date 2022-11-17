
# remove student submission folder
rm -rf student-submission

# git clone the repo provided
git clone $1 student-submission

# check if file exists
if [ -f ./student-submission/ListExamples.java ]
then
    echo "Found student java file..."
else
    echo "No student java file..."
    exit 1
fi

#copy the needed files for testing
cp ./TestListExamples.java ./student-submission
cp -r ./lib ./student-submission

#go to dir
cd ./student-submission

javac -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar *.java

if [ $? -eq 0 ]
then
    echo "Compiled..."
else
    echo "Did not compile..."
    echo $?
    exit 1
fi
echo "--------"
echo "Running tests..."

java -cp .:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar org.junit.runner.JUnitCore TestListExamples > results.txt

echo "Test output:"
grep -i "test" results.txt