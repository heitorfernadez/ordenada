package ordenacao;

public class HeapSort {

    public void heapSort(int arr[]) {
        int n = arr.length;

        // Construir o heap máximo
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extraindo um a um os elementos do heap
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Chama o heapify no heap reduzido
            heapify(arr, i, 0);
        }
    }

    // Para transformar uma subárvore em heap
    void heapify(int arr[], int n, int i) {
        int largest = i; // Inicializa o maior como raiz
        int left = 2 * i + 1; // Filho esquerdo
        int right = 2 * i + 2; // Filho direito

        // Se o filho esquerdo for maior que a raiz
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Se o filho direito for maior que o maior até agora
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Se o maior não for a raiz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursivamente transforma o subárvore afetado em heap
            heapify(arr, n, largest);
        }
    }

    // Método auxiliar para imprimir o array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Programa principal para testar o Heap Sort
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}
