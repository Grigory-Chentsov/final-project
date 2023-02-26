/* Написать программу, которая из имеющегося массива строк формирует массив из строк, длина которых
меньше либо равна 3 символам. */

string[] array = { "Moscow", "123", ":-)", "IT", "+", "GeekBrains" };

string[] SortArray(string[] array)
{
    string[] newArray = new string[0];
    int count = 0;
    for (int i = 0; i < array.Length; i++)
    {
        if (array[i].Length <= 3)
        {   
            Array.Resize<string>(ref newArray, newArray.Length + 1);
            newArray[count] = array[i];            
            count++;
        }
    }
    return newArray;
}

void PrintMatrix()
{
    string[] newA = SortArray(array);
    for (int i = 0; i < newA.Length; i++)
    {
        Console.Write(newA[i] + ", ");
    }
}

PrintMatrix();
